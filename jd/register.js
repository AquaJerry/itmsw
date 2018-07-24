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
 * The input for a password to be used.
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
 * The input for a user name to be used.
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

  if ('' == userName) {
    alert('User name should not be empty.');
    return false;
  } else if (lenUserName < 4 || lenUserName > 20) {
    alert('User name should have 4 to 20 characters.');
    return false;
  } else if (isUserNameANum) {
    alert('User name should not only contain numbers.');
    return false;
  } else {
    alert('User name is correct.');
  }

  if ('' == password) {
    alert('Password should not be empty.');
    return false;
  } else if (lenPassword < 6 || lenPassword > 20) {
    alert('Password should have 6 to 20 characters.');
    return false;
  } else {
    alert('Password is correct.');
  }

  if ('' == repassword) {
    alert('Please confirm your password.');
    return false;
  } else if (repassword != password) {
    alert('The two passwords you typed do not match.');
    return false;
  } else {
    alert('Password is confirmed.');
  }

  if ('' == phone) {
    alert('Phone number should not be empty.');
    return false;
  } else if (11 != lenPhone) {
    alert('Phone number should have 11 digits.');
    return false;
  } else if (isPhoneNaN) {
    alert('Phone number should only contain numbers.');
    return false;
  } else {
    alert('Phone number is correct.');
  }

  if ('' == validateCode) {
    alert('Verification code should not be empty.');
    return false;
  } else if (6 != lenValidateCode) {
    alert('Verification code should have 6 digits.');
    return false;
  } else if (isValidateCodeNaN) {
    alert('Verification code should only contain numbers.');
    return false;
  } else {
    alert('Verification code is correct.');
  }
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
