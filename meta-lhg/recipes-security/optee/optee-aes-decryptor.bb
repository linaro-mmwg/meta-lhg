SUMMARY = "OPTEE AES Decryptor for Linaro OpenCDM"
DESCRIPTION = "OPTEE AES Decryptor for Linaro OpenCDM"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=22b593390e65f8d23beaa6ef10ed6392"
PR="r0"
PV="1.0+git"

DEPENDS = "${OPTEE_PACKAGES}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/linaro-mmwg/optee-clearkey-cdmi;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
B = "${S}"

#stub
do_configure[noexec] = "1"

OPTEE_ARCH ?= ""
OPTEE_ARCH_aarch64 = "arm64"

OPTEE_EXPORT_USERTA_DIR ?= "export-user_ta"
OPTEE_EXPORT_USERTA_DIR_mx8 = "export-user_ta_${OPTEE_ARCH}"


EXTRA_OEMAKE = ""
do_compile() {
    export TA_DEV_KIT_DIR=${STAGING_INCDIR}/optee/${OPTEE_EXPORT_USERTA_DIR}
    export TEEC_EXPORT=${STAGING_DIR_HOST}/usr

    oe_runmake -C ${S}/host LDFLAGS=""

    oe_runmake -C ${S}/ta LDFLAGS="" CROSS_COMPILE=${HOST_PREFIX}
}

do_install() {
    mkdir -p ${D}/usr/bin
    mkdir -p ${D}/lib/optee_armtz
    install -d ${D}/${libdir}
    install -m 0644 ${S}/host/*.a ${D}/${libdir}/
    install -m 0644 ${S}/host/*.so ${D}/${libdir}/

    install -d ${D}${includedir}
    install -m 0644 ${S}/host/*.h ${D}${includedir}/

    #ta part
    install -m 444 ${B}/ta/*.ta ${D}/lib/optee_armtz/
}


FILES_${PN} = "${libdir}/*.a ${libdir}/*.so /usr/bin /lib/optee_armtz/"
FILES_${PN}-staticdev = "${libdir}/*.a"
FILES_${PN}-dev = "${libdir}/*.so"

INSANE_SKIP_${PN}-dev += "dev-elf"

INHIBIT_PACKAGE_STRIP = "1"
