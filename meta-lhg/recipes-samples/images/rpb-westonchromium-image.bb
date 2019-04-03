require recipes-samples/images/rpb-weston-image.bb

ACCEL_FW = ""

ACCEL_FW_append_omap-a15 = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw', '', d)} \
"

GSTREAMER_ACCEL_MM = ""
GSTREAMER_ACCEL_MM_omap-a15 = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', "gstreamer1.0-plugins-ducati", '', d)}"
GSTREAMER_ACCEL_MM_append_dra7xx = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', " gstreamer1.0-plugins-vpe", '', d)}"

MULTIMEDIA_TESTS = "igt-gpu-tools"

CORE_IMAGE_BASE_INSTALL += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'optee-aes-decryptor ocdmi rpcbind', '', d)} \
    ${ACCEL_FW} \
    ${GSTREAMER_ACCEL_MM} \
    ${MULTIMEDIA_TESTS} \
    "
