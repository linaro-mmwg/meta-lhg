SUMMARY = "OPTEE components"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    optee-os \
    optee-client \
    optee-ta-luc14-helloworld \
    optee-test \
    optee-aes-decryptor \
    ocdmi \
    portmap \
    "
# kernel-module-optee* aren't used starting from OPTEE 2.0
RRECOMMENDS_${PN} = " \
    kernel-module-optee \
    kernel-module-optee-armtz \
    "
