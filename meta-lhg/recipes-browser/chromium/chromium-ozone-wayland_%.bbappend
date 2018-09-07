PACKAGECONFIG[use-ocdm] = "enable_opencdm=true,enable_opencdm=false"

PACKAGECONFIG_append = " ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'use-ocdm', '', d)} proprietary-codecs"

OCDM_GIT_BRANCH="chromium-65.0.3315.0.r527534.igalia"
OCDM_DESTSUFIX="ocdm"

SRC_URI += "${@bb.utils.contains('PACKAGECONFIG', 'use-ocdm', '\
    git://github.com/linaro-mmwg/open-content-decryption-module.git;protocol=https;branch=${OCDM_GIT_BRANCH};name=ocdm;destsuffix=${OCDM_DESTSUFIX}\
    ', '', d)}"
SRCREV_ocdm = "${AUTOREV}"
DEPENDS_append = " ${@bb.utils.contains('PACKAGECONFIG', 'use-ocdm', 'ocdmi', '', d)} "

python add_ocdm_patches() {
    srcdir = d.getVar('WORKDIR', True)
    d.appendVar('SRC_URI', " file://" + srcdir + "/ocdm/patch/add_ocdm_keyssystems.patch")
}

copy_ocdm_files() {
    cp -r ${WORKDIR}/ocdm ${S}/media/cdm/ppapi/external_open_cdm
}

do_patch[prefuncs] += "${@bb.utils.contains('PACKAGECONFIG', 'use-ocdm', 'add_ocdm_patches', '', d)}"
do_unpack[postfuncs] += "${@bb.utils.contains('PACKAGECONFIG', 'use-ocdm', 'copy_ocdm_files', '', d)}"

do_install_append() {
    if [ -n "${@bb.utils.contains('PACKAGECONFIG', 'use-ocdm', 'use-ocdm', '', d)}" ]; then
        install -Dm 0755 ${B}/libopencdmadapter.so \
            ${D}${libdir}/chromium/libopencdmadapter.so
        install -Dm 0755 ${B}/libopencdm.so \
            ${D}${libdir}/chromium/libopencdm.so
    fi
}
