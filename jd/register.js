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
 * The tip for the password to be used.
 *
 * @type {HTMLElement}
 */
let $passwordTip = $('passwordTip');

/**
 * The input for the phone number to be used.
 *
 * @type {HTMLElement}
 */
let $phone = $('phone');

/**
 * The tip for the phone number to be used.
 *
 * @type {HTMLElement}
 */
let $phoneTip = $('phoneTip');

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
 * The tip for confirming a password to be used.
 *
 * @type {HTMLElement}
 */
let $repasswordTip = $('repasswordTip');

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
 * The tip for the user name to be used.
 *
 * @type {HTMLElement}
 */
let $userNameTip = $('userNameTip');

/**
 * The input for the valification code user got.
 *
 * @type {HTMLElement}
 */
let $validateCode = $('validateCode');

/**
 * The tip for the valification code user got.
 *
 * @type {HTMLElement}
 */
let $validateCodeTip = $('validateCodeTip');

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
    $userNameTip.innerHTML = 'User name should not be empty.';
    return false;
  } else if (lenUserName < 4 || lenUserName > 20) {
    $userNameTip.innerHTML = 'User name should have 4 to 20 characters.';
    return false;
  } else if (isUserNameANum) {
    $userNameTip.innerHTML = 'User name should not only contain numbers.';
    return false;
  } else {
    $userNameTip.innerHTML = 'User name is correct.';
  }

  if ('' == password) {
    $passwordTip.innerHTML = 'Password should not be empty.';
    return false;
  } else if (lenPassword < 6 || lenPassword > 20) {
    $passwordTip.innerHTML = 'Password should have 6 to 20 characters.';
    return false;
  } else {
    $passwordTip.innerHTML = 'Password is correct.';
  }

  if ('' == repassword) {
    $repasswordTip.innerHTML = 'Please confirm your password.';
    return false;
  } else if (repassword != password) {
    $repasswordTip.innerHTML = 'The two passwords you typed do not match.';
    return false;
  } else {
    $repasswordTip.innerHTML = 'Password is confirmed.';
  }

  if ('' == phone) {
    $phoneTip.innerHTML = 'Phone number should not be empty.';
    return false;
  } else if (11 != lenPhone) {
    $phoneTip.innerHTML = 'Phone number should have 11 digits.';
    return false;
  } else if (isPhoneNaN) {
    $phoneTip.innerHTML = 'Phone number should only contain numbers.';
    return false;
  } else {
    $phoneTip.innerHTML = 'Phone number is correct.';
  }

  if ('' == validateCode) {
    $validateCodeTip.innerHTML = 'Verification code should not be empty.';
    return false;
  } else if (6 != lenValidateCode) {
    $validateCodeTip.innerHTML = 'Verification code should have 6 digits.';
    return false;
  } else if (isValidateCodeNaN) {
    $validateCodeTip.innerHTML = 'Verification code should only be numbers.';
    return false;
  } else {
    $validateCodeTip.innerHTML = 'Verification code is correct.';
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
