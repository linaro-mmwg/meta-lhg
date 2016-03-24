SUMMARY = "Weston configuration file with systemd"
DESCRIPTION = "Weston configuration file installation with systemd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420 "

SRC_URI = " file://weston.ini \
            file://utilities-terminal.png \
            file://chromium-browser.png \
            file://wallpaper_1920x1080.png "

SRC_URI += " file://weston.service \
             file://weston.sh \
             file://weston_profile.sh "

FILES_${PN} = "\
    /tmp/xdg_runtime_dir \
    /usr/share/weston/weston.ini \
    /usr/share/weston/icon/utilities-terminal.png \
    /usr/share/weston/icon/chromium-browser.png \
    /usr/share/weston/wallpaper_linaro_1920x1080.png "

FILES_${PN} += "/lib/systemd/system/weston.service \
            /usr/sbin/weston.sh \
            /etc/systemd/system/multi-user.target.wants/display-manager.service \
            /etc/profile.d/"

WESTON_OUT_NAME ?= "HDMI1"
WESTON_OUT_MODE ?= "preferred"

do_install() {
  install -d ${D}/usr/share/weston
  install -d ${D}/usr/share/weston/icon
  sed -i -e "s/##WESTON_OUT_NAME##/${WESTON_OUT_NAME}/g" ${WORKDIR}/weston.ini
  sed -i -e "s/##WESTON_OUT_MODE##/${WESTON_OUT_MODE}/g" ${WORKDIR}/weston.ini
  install -m 0644 ${WORKDIR}/weston.ini ${D}/usr/share/weston/weston.ini
  install -m 0644 ${WORKDIR}/utilities-terminal.png ${D}/usr/share/weston/icon/utilities-terminal.png
  install -m 0644 ${WORKDIR}/chromium-browser.png ${D}/usr/share/weston/icon/chromium-browser.png
  install -m 0644 ${WORKDIR}/wallpaper_1920x1080.png ${D}/usr/share/weston/wallpaper_linaro_1920x1080.png

  install -d ${D}/lib/systemd/system/ ${D}/usr/sbin
  install -m 0644 ${WORKDIR}/weston.service ${D}/lib/systemd/system/
  install -m 0755  ${WORKDIR}/weston.sh ${D}/usr/sbin

  install -d ${D}/etc/systemd/system/ ${D}/etc/systemd/system/multi-user.target.wants/
  ln -s /lib/systemd/system/weston.service ${D}/etc/systemd/system/multi-user.target.wants/display-manager.service

  install -d ${D}/etc/profile.d
  install -m 0755 ${WORKDIR}/weston_profile.sh ${D}/etc/profile.d/
}
