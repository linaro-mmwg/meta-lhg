FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit systemd

SRC_URI_append = " \
    file://0001-HACK-bump-up-egl-s-and-wayland-egl-s-version-numbers.patch \
    file://rc.pvr.service \
    "

do_install_append () {
    (cd ${D}/${libdir} && ln -sf libGLESv2.so libGLESv2.so.2)

    sed -i -e s:/usr/bin:${bindir}:g ${WORKDIR}/rc.pvr.service
    install -d ${D}/lib/systemd/system/
    install -m 0644 ${WORKDIR}/rc.pvr.service ${D}/lib/systemd/system

    cp ${D}${sysconfdir}/init.d/rc.pvr ${D}${bindir}/pvr-init
}

SYSTEMD_SERVICE_${PN} = "rc.pvr.service"

FILES_${PN} += "/lib/systemd/system/rc.pvr.service"
