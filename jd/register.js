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
 * The button to agree with terms & conditions.
 *
 * @type {HTMLElement}
 */
let $agreePopup = $('agreePopup');

/**
 * The button to disagree against terms & conditions.
 *
 * @type {HTMLElement}
 */
let $cancelPopup = $('cancelPopup');

/**
 * The icon in the title bar to disagree against terms & conditions.
 *
 * @type {HTMLElement}
 */
let $exitPopup = $('exitPopup');

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
 * The form where a user register.
 *
 * @type {HTMLElement}
 */
let $registerForm = $('registerForm');

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
 * The input for the valification code user got.
 *
 * @type {HTMLElement}
 */
let $validateCode = $('validateCode');

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
 * Set the display css property
 * of the mask layer and the popup terms & conditions.
 *
 * @param {'none'|'block'} display - hide if 'none', or show if 'block'
 */
function setDisplay(display) {
  cssTermPopup.display = cssMask.display = display;
}

/**
 * Whether the validation of register form is success
 *
 * @type {boolean}
 */
let success;

/**
 * The latest tip from the controller.
 *
 * It usually is an error message sent to user.
 *
 * @type {string}
 */
let tip;

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
 * Update a tip on the view for registering.
 *
 * If a tip is updated (not empty), redraw and show it on the view,
 * clear it in the model, and fail the validation of register form.
 *
 * Otherwise reset (hide by default) parts of the view
 * where it is redrawn and showed.
 *
 * @param {string} tipId - The ID about parts of the view where the tip is
 */
function updateTip(tipId) {
  let cssCell = $(tipId + 'TipCell').style;

  if (tip) {
    $(tipId + 'Tip').innerHTML = tip;
    cssCell.visibility = 'visible';
    success = tip = false;
  } else {
    cssCell.visibility = '';
  }
}

/**
 * Validate register form before submit.
 *
 * @return {boolean} Whether the submit is OK
 */
function validate() {
  let password = $password.value;
  let phone = $phone.value;
  let repassword = $repassword.value;
  let userName = $userName.value;
  let validateCode = $validateCode.value;

  let isPhoneNaN = isNaN(phone);
  let isUserNameANum = !isNaN(userName);
  let isValidateCodeNaN = isNaN(validateCode);
  let lenPassword = password.length;
  let lenPhone = phone.length;
  let lenUserName = userName.length;
  let lenValidateCode = validateCode.length;

  success = true;

  if ('' == userName) {
    tip = 'User name should not be empty.';
  } else if (lenUserName < 4 || lenUserName > 20) {
    tip = 'User name should have 4 to 20 characters.';
  } else if (isUserNameANum) {
    tip = 'User name should not only contain numbers.';
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

  updateTip('validateCode');

  return success;
}

/* Initial Script Below */

/* Load the popup */
setDisplay('block');

/* Listen agree button */
$agreePopup.onclick = agreePopup;

/* Listen cancel buttons */
$cancelPopup.onclick = cancelPopup;
$exitPopup.onclick = cancelPopup;

/* Listen submit of form */
$registerForm.onsubmit = validate;
