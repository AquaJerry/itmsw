/**
 * @file Jingdong/Joybuy Register Page
 * @author AquaJerry <huopopo_zeyang@163.com>
 * @see	https://github.com/AuqaJerry/itmsw
 */

/**
 * Get an element by its ID.
 *
 * @param {string} i - The ID
 * @returns {HTMLElement|null} The element, or null if not found
 */
function $(i){return document.getElementById(i)}

/**
 * The mask layer valid when register page loads.
 *
 * @type {HTMLElement}
 */
var $mask = $('mask')

/**
 * The style of the mask layer.
 *
 * @type {CSS2Properties}
 */
var cssMask = $mask.style

/**
 * The terms & conditions that popups when register page loads.
 *
 * @type {HTMLElement}
 */
var $termPopup = $('termPopup')

/**
 * The style of the popup of terms & conditions.
 *
 * @type {CSS2Properties}
 */
var cssTermPopup = $termPopup.style

/**
 * Set the display css property
 * of the mask layer and the popup terms & conditions.
 *
 * @param {'none'|'block'} display - hide if 'none', or show if 'block'
 */
function setDisplay(display) {
	cssTermPopup.display = cssMask.display = display
}

/**
 * Close the popup and stay in the register page.
 */
function agreePopup() {
	setDisplay('none')
}

/**
 * Redirect to the login page.
 */
function cancelPopup() {
	location = 'login.html'
}

/* Initial Script Below */

/**
 * Load the popup.
 */
setDisplay('block')
