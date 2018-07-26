/**
 * @file Jingdong/Joybuy Register Page
 * @author AquaJerry <huopopo_zeyang@163.com>
 * @see https://github.com/AuqaJerry/itmsw
 */

/**
 * Get an element by its ID.
 *
 * @param {string} i - The ID
 * @return {HTMLElement|null} The element, or null if not found
 */
let $ = (i) => document.getElementById(i);

/**
 * The mask layer valid when register page loads.
 *
 * @type {HTMLElement}
 */
let $mask = $('mask');

/**
 * The input for the password to be used.
 *
 * @type {HTMLElement}
 */
let $password = $('password');

/**
 * The input for the phone number to be used.
 *
 * @type {HTMLElement}
 */
let $phone = $('phone');

/**
 * The input for confirming a password to be used.
 *
 * @type {HTMLElement}
 */
let $repassword = $('repassword');

/**
 * The terms & conditions that popups when register page loads.
 *
 * @type {HTMLElement}
 */
let $termPopup = $('termPopup');

/**
 * The input for the user name to be used.
 *
 * @type {HTMLElement}
 */
let $userName = $('userName');

/**
 * The input for the valification code.
 *
 * @type {HTMLElement}
 */
let $validateCode = $('validateCode');

/**
 * The icon of status about the valification code user typed.
 *
 * @type {HTMLElement}
 */
let $vcStatus = $('validateCodeStatus');

/**
 * The tip about valification code.
 *
 * @type {HTMLElement}
 */
let $vcTip = $('validateCodeTip');

/**
 * The style of the mask layer.
 *
 * @type {CSS2Properties}
 */
let cssMask = $mask.style;

/**
 * The style of the popup of terms & conditions.
 *
 * @type {CSS2Properties}
 */
let cssTermPopup = $termPopup.style;

/**
 * The style of the tip about the validation code.
 *
 * @type {CSS2Properties}
 */
let cssVcTip = $vcTip.style;

/**
 * Set the display css property of the mask layer and
 *     the popup terms & conditions.
 *
 * @param {'none'|'block'} display - Hide if 'none', or show if 'block'
 */
function setDisplay(display) {
  cssTermPopup.display = cssMask.display = display;
}

/**
 * Whether the validation of register form is success.
 *
 * @type {boolean}
 */
let success;

/**
 * @summary The latest tip from the controller.
 * @type {string}
 * @description It usually is an error message sent to user.
 */
let tip;

/**
 * @summary Update a tip on the view for registering.
 * @param {string} tipId - The ID about parts of the view where the tip is
 * @description If a tip is updated (not empty), redraw it, show it on the view
 *     if it is the first tip of the whole register form, clear it in the model,
 *     and fail the validation of register form.<br>
 *     Otherwise reset (hide by default) parts of the view where it is redrawn
 *     and showed.<br>
 *     During above cases, the message of success resets (hides by default) and
 *     shows respectively.<br>
 *     Focus on the input from which the first tip comes.
 */
function updateTip(tipId) {
  let cssCell = $(tipId + 'TipCell').style;
  let cssIcon = $(tipId + 'Correct').style;

  if (tip) {
    $(tipId + 'Tip').innerHTML = tip;
    cssIcon.visibility = '';
    if (success) {
      $(tipId).focus();
      cssCell.visibility = 'visible';
    } else {
      cssCell.visibility = ''
    }
    success = tip = false;
  } else {
    cssCell.visibility = '';
    cssIcon.visibility = 'visible';
  }
}

/**
 * The prefix of image source of the status of verification code.
 *
 * @type {string}
 */
let vcStatusImgSrcPre = 'common/images/jd_icon_';

/**
 * The suffix of image source of the status of verification code.
 *
 * @type {string}
 */
let vcStatusImgSrcSuf = '.png';

/* Initial Script Below */

/**
 * Close the popup and stay in the register page.
 *
 * @global
 */
window.agreePopup = () => {
  setDisplay('none');
  $userName.focus();
};

/**
 * Redirect to the login page.
 *
 * @global
 */
window.cancelPopup = () => {
  window.location = 'login.html';
};

/**
 * @summary Validate register form before submit.
 * @global
 * @return {boolean} Whether the submit is OK
 * @description First, assume the validation is success. Then do all validations
 *     in series.
 */
window.validate = () => {
  let password = $password.value;
  let phone = $phone.value;
  let repassword = $repassword.value;
  let userName = $userName.value;
  let validateCode = $validateCode.value;

  var hasUserNameInvalidChar = /[^\u4e00-\u9fa5a-zA-Z0-9-_]/.test(userName)
  let isPhoneNaN = isNaN(phone);
  let isUserNameANum = !/[^0-9]/.test(userName)
  var isUserNameEmpty = /^$/.test(userName)
  var isUserNameTooShortOrLong = !/^.{4,20}$/.test(userName)
  let isValidateCodeNaN = isNaN(validateCode);
  let lenPassword = password.length;
  let lenPhone = phone.length;
  let lenValidateCode = validateCode.length;

  success = true;

  if (isUserNameEmpty) {
    tip = 'User name should not be empty.';
  } else if (isUserNameTooShortOrLong) {
    tip = 'User name should have 4 to 20 characters.';
  } else if (isUserNameANum) {
    tip = 'User name should not only contain numbers.';
  } else if (hasUserNameInvalidChar) {
    tip = 'User name can only contain Chinese, letters, numbers, - or _.'
  }

  updateTip('userName');

  if ('' == password) {
    tip = 'Password should not be empty.';
  } else if (lenPassword < 6 || lenPassword > 20) {
    tip = 'Password should have 6 to 20 characters.';
  }

  updateTip('password');

  if ('' == repassword) {
    tip = 'Please confirm your password.';
  } else if (repassword != password) {
    tip = 'The two passwords you typed do not match.';
  }

  updateTip('repassword');

  if ('' == phone) {
    tip = 'Phone number should not be empty.';
  } else if (11 != lenPhone) {
    tip = 'Phone number should have 11 digits.';
  } else if (isPhoneNaN) {
    tip = 'Phone number should only contain numbers.';
  }

  updateTip('phone');

  if ('' == validateCode) {
    tip = 'Verification code should not be empty.';
  } else if (6 != lenValidateCode) {
    tip = 'Verification code should have 6 digits.';
  } else if (isValidateCodeNaN) {
    tip = 'Verification code should only be numbers.';
  }

  /**
   * @summary Update tip of verification code.
   * @see updateTip
   * @description If the tip is both updated and the first of the whole register
   *     form, draw it (in warning color by default). If this tip is not the
   *     first, clear what has been drawn.<br>
   *     If the tip is not updated, draw a tip of success in green.<br>
   *     In above two cases, a relevant status icon is also drawn.
   */
  if (tip) {
    if (success) {
      $validateCode.focus();
      $vcStatus.src = vcStatusImgSrcPre+ 'error' +vcStatusImgSrcSuf;
      $vcTip.innerHTML = tip;
      cssVcTip.color = '';
    } else {
      $vcStatus.src = $vcTip.innerHTML = '';
    }
    success = tip = false;
  } else {
    $vcStatus.src = vcStatusImgSrcPre +'correct' + vcStatusImgSrcSuf;
    $vcTip.innerHTML = 'Verification code is correct.';
    cssVcTip.color = '#43c75a';
  }

  return success;
};

// Load the popup
setDisplay('block');
