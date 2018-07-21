/**
 * @file	register.js
 * @description	What executed after the Jingdong/Joybuy register page loads.
 * @author	AquaJerry <huopopo_zeyang@163.com>
 * @see		<https://github.com/AuqaJerry/itmsw>
 */

/**
 * Get an element by its ID.
 *
 * @param {string} i - the ID
 * @return {HTMLElement|null} - the element, or null if not found
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
 * Load the popup.
 */
cssTermPopup.display = cssMask.display = 'block'
