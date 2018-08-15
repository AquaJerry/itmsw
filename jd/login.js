/**
 * @file Jingdong/Joybuy Login Page
 * @author AquaJerry <huopopo_zeyang@163.com>
 * @see https://github.com/AuqaJerry/itmsw
 */
/* Initial Script Below */
let isTypo = /flag=loginError/.test(location);
if (isTypo) {
  document.getElementById('typoTip').style.visibility = 'visible';
}
