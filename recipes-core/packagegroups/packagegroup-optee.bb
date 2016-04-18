SUMMARY = "OPTEE components"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    kernel-module-optee-armtz \
    optee-os \
    optee-client \
    optee-ta-luc14-helloword \
    "
RRECOMMENDS_${PN} = " \
    kernel-module-optee
    "
