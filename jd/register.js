/**
 * @file Jingdong/Joybuy Register Page
 * @author AquaJerry <huopopo_zeyang@163.com>
 * @see https://github.com/AuqaJerry/itmsw
 */

/**
 * Get an element by its ID.
 *
 * @param {string} i - The ID
 * @returns {HTMLElement|null} The element, or null if not found
 */
function $(i) { return document.getElementById(i); }

/**
 * The button to agree with terms & conditions.
 *
 * @type {HTMLElement}
 */
const $agreePopup = $('agreePopup');

/**
 * The button to disagree against terms & conditions.
 *
 * @type {HTMLElement}
 */
const $cancelPopup = $('cancelPopup');

/**
 * The icon in the title bar to disagree against terms & conditions.
 *
 * @type {HTMLElement}
 */
const $exitPopup = $('exitPopup');

/**
 * The mask layer valid when register page loads.
 *
 * @type {HTMLElement}
 */
const $mask = $('mask');

/**
 * The style of the mask layer.
 *
 * @type {CSS2Properties}
 */
const cssMask = $mask.style;

/**
 * The form where a user register.
 *
 * @type {HTMLElement}
 */
const $registerForm = $('registerForm');

/**
 * The terms & conditions that popups when register page loads.
 *
 * @type {HTMLElement}
 */
const $termPopup = $('termPopup');

/**
 * The style of the popup of terms & conditions.
 *
 * @type {CSS2Properties}
 */
const cssTermPopup = $termPopup.style;

/**
 * The input for a user name to be used.
 *
 * @type {HTMLElement}
 */
const $userName = $('userName');

/**
 * Set the display css property
 * of the mask layer and the popup terms & conditions.
 *
 * @param {'none'|'block'} display - hide if 'none', or show if 'block'
 */
function setDisplay(display) {
  cssTermPopup.display = display;
  cssMask.display = display;
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
 * @returns {boolean} Whether the submit is OK
 */
function validate() {
  const userName = $userName.value;

  const isUserNameANum = !isNaN(userName);
  const lenUserName = userName.length;

  if (userName === '') {
    alert('User name should not be empty.');
    return false;
  } else if (lenUserName < 4 || lenUserName > 20) {
    alert('User name should have 4 to 20 characters.');
    return false;
  } else if (isUserNameANum) {
    alert('User name should not only contain number.');
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
