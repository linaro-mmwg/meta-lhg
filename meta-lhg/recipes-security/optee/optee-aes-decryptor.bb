SUMMARY = "OPTEE AES Decryptor for Linaro OpenCDM"
DESCRIPTION = "OPTEE AES Decryptor for Linaro OpenCDM"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=f0fb2f357d31d6a98213b19f57abf927"
PR="r0"
PV="1.0+git"

DEPENDS = "optee-os optee-client"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/kuscsik/optee-clearkey-cdmi;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
B = "${S}"

#stub
do_configure[noexec] = "1"

EXTRA_OEMAKE = ""
do_compile() {
    export TA_DEV_KIT_DIR=${STAGING_INCDIR}/optee/export-user_ta
    export TEEC_EXPORT=${STAGING_DIR_HOST}/usr

    oe_runmake -C ${S}/host LDFLAGS=""

    oe_runmake -C ${S}/ta LDFLAGS="" CROSS_COMPILE=${HOST_PREFIX}
}

do_install() {
    mkdir -p ${D}/usr/bin
    mkdir -p ${D}/lib/optee_armtz
    install -d ${D}/${libdir}
    install -m 0644 ${S}/host/*.a ${D}/${libdir}/

    install -d ${D}${includedir}
    install -m 0644 ${S}/host/*.h ${D}${includedir}/

    #ta part
    install -m 444 ${B}/ta/*.ta ${D}/lib/optee_armtz/
}


FILES_${PN} = "${libdir}/*.a  /usr/bin /lib/optee_armtz/"
FILES_${PN}-staticdev = "${libdir}/*.a"

INHIBIT_PACKAGE_STRIP = "1"
