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
 * The image of the validation code.
 *
 * @type {HTMLElement}
 */
let $validationCode = $('validationCode');

/**
 * Close the popup and stay in the register page.
 */
function agreePopup() {
  setDisplay('none');
  $userName.focus();
}

/**
 * Redirect to the login page.
 */
function cancelPopup() {
  window.location = 'login.html';
}

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
 * Request another image of validation code.
 */
function getValidationCode() {
  $validationCode.src = 'maintain/ValidationCodeServlet?' + Date.now();
}

/**
 * Page element identified by id listens to click to redirect to the login page.
 *
 * @param {string} id - The id
 */
function listenCancelPopup(id) {
  $(id).onclick = cancelPopup;
}

/**
 * The latest review for what the user inputs.
 *
 * @type {string}
 */
let review;

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
 * @summary Describe how user's input is.
 * @type {string}
 * @description E.g: 'weak': The user typed a quite simple password.<br>
 *     'correct': The user typed the validation code as the page wants.
 */
let state;

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
 * The latest tip color.
 *
 * @type {string}
 */
let tipColor;

/**
 * @summary Redraw a tip.
 * @param {string} id - The ID of where the tip is
 * @description If the tip is the first tip of the whole register form,
 *     redraw and show it, focus on the input where this tip comes.<br>
 *     If not the first, clear the view where it could be.<br>
 *     Any tip fails the validation of register form.<br>
 *     If that validation is success, redraw the view with review.<br>
 *     The pass and status icon also update relatively.
 */
function updateTip(id) {
  let $pass = $(id + 'Pass');
  let $tip = $(id + 'Tip');
  let cssTip = $tip.style;

  if ($pass) $pass.style.visibility = tip ? '' : 'visible';

  if (success && tip) state = state || 'error';
  $(id + 'State').src = state ? 'common/images/jd_icon_' + state + '.png' : '';
  state = false;

  if (tip) {
    if (success) {
      $(id).focus();
      $tip.innerHTML = tip;
      cssTip.color = '';
    } else {
      $tip.innerHTML = '';
    }
    success = tip = false;
  } else {
    $tip.innerHTML = review || '';
    cssTip.color = tipColor || '#43c75a';
    review = tipColor = false;
  }
}

/**
 * @summary Validate register form before submit.
 * @global
 * @return {boolean} Whether the submit is OK
 * @description First, assume the validation is success. Then do all validations
 *     in series.
 */
function validate() {
  let password = $password.value;
  let phone = $phone.value;
  let repassword = $repassword.value;
  let userName = $userName.value;
  let validateCode = $validateCode.value;

  let isPasswordSafe = /^(?!\D+$)(?![^a-zA-Z]+$)(?![0-9a-zA-Z]+$)/
    .test(password);
  let isPasswordTooShortOrLong = !/^.{6,20}$/.test(password);
  let isPasswordWeak = /^(\d+|[a-zA-Z]+|[^0-9a-zA-Z]+)$/.test(password);
  let isPhoneMalformed = !/^1([38]|5[^4]|4[57]|7[678])/.test(phone);
  let isPhoneNaN = isNaN(phone);
  let isUserNameANum = !/\D/.test(userName);
  let isUserNameMalformed = /[^\u4e00-\u9fa5\w-]/.test(userName);
  let isUserNameTooShortOrLong = !/^.{4,20}$/.test(userName);
  let isValidateCodeNaN = isNaN(validateCode);

  success = true;

  if ('' == userName) {
    tip = 'User name should not be empty.';
  } else if (isUserNameTooShortOrLong) {
    tip = 'User name should have 4 to 20 characters.';
  } else if (isUserNameANum) {
    tip = 'User name should not only contain numbers.';
  } else if (isUserNameMalformed) {
    tip = 'User name can only contain Chinese, letters, numbers, - or _.';
  }

  updateTip('userName');

  if ('' == password) {
    tip = 'Password should not be empty.';
  } else if (isPasswordTooShortOrLong) {
    tip = 'Password should have 6 to 20 characters.';
  } else if (isPasswordWeak) {
    state = 'weak';
    tip = 'Weak password. Please use letter, number, or symbol together.';
  } else if (isPasswordSafe) {
    review = 'Your password is safe.';
    state = 'safe';
  } else {
    review = 'Your password is OK. Combine letter, digit, and symbol is safer.';
    state = 'medium';
    tipColor = '#cfdaed';
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
  } else if (11 != phone.length) {
    tip = 'Phone number should have 11 digits.';
  } else if (isPhoneNaN) {
    tip = 'Phone number should only contain numbers.';
  } else if (isPhoneMalformed) {
    tip = 'Phone number is malformed.';
  }

  updateTip('phone');

  if ('' == validateCode) {
    tip = 'Verification code should not be empty.';
  } else if (6 != validateCode.length) {
    tip = 'Verification code should have 6 digits.';
  } else if (isValidateCodeNaN) {
    tip = 'Verification code should only be numbers.';
  } else {
    review = 'Verification code is correct.';
    state = 'pass';
  }

  updateTip('validateCode');

  return success;
}

/* Initial Script Below */

// Load the popup
setDisplay('block');

// listen to register
$('agreePopup').onclick = agreePopup;

// listen to login
['cancelPopup', 'exitPopup'].forEach(listenCancelPopup);

// listen to submit
$('registerForm').onsubmit = validate;

// listen to change validation code
$('changeValidationCode').onclick = getValidationCode;
