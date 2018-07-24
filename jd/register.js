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
 * The form where a user register.
 *
 * @type {HTMLElement}
 */
let $registerForm = $('registerForm');

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
  let userName = $userName.value;

  let isUserNameANum = !isNaN(userName);
  let lenUserName = userName.length;

  if ('' == userName) {
    alert('User name should not be empty.');
    return false;
  } else if (lenUserName < 4 || lenUserName > 20) {
    alert('User name should have 4 to 20 characters.');
    return false;
  } else if (isUserNameANum) {
    alert('User name should not only contain number.');
    return false;
  } else {
    alert('User name is correct.');
  }

  if ('' == password) {
    alert('Password should not be empty.');
    return false;
  } else {
    return true;
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
