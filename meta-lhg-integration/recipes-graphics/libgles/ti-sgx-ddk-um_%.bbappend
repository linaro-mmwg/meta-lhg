FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit systemd

SRC_URI_append = " \
    file://0001-Change-egl-and-wayland-egl-version-numbers.patch \
    file://rc.pvr.service \
    "

do_install_append () {
    sed -i -e s:/usr/bin:${bindir}:g ${WORKDIR}/rc.pvr.service
    install -d ${D}/lib/systemd/system/
    install -m 0644 ${WORKDIR}/rc.pvr.service ${D}/lib/systemd/system

    cp ${D}${sysconfdir}/init.d/rc.pvr ${D}${bindir}/pvr-init
}

SYSTEMD_SERVICE_${PN} = "rc.pvr.service"

FILES_${PN} += "/lib/systemd/system/rc.pvr.service"
