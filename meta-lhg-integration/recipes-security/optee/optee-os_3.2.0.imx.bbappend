FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRCBRANCH = "oemcrypto_v15"
OPTEE_OS_SRC = "git://github.com/petegriffin/optee_os.git;protocol=https"
SRC_URI = "\
       ${OPTEE_OS_SRC};branch=${SRCBRANCH} \
        file://0001-core-modify-tee_otp_get_hw_unique_key-to-return-TEE_.patch \
        file://0001-build-remove-pedantic-from-build-directives.patch \
        file://0001-scripts-update-scripts-to-use-python3.patch \
"

SRCREV = "e9667475500c842b943e3f457ea88236e4e9ab5c"
