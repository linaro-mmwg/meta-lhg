require recipes-samples/images/rpb-weston-image.bb

ACCEL_FW = ""

ACCEL_FW_append_am57xx-evm = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw', '', d)} \
"

GSTREAMER_ACCEL_MM = ""
GSTREAMER_ACCEL_MM_omap-a15 = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', "gstreamer1.0-plugins-ducati", '', d)}"
GSTREAMER_ACCEL_MM_append_dra7xx = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', " gstreamer1.0-plugins-vpe", '', d)}"

CORE_IMAGE_BASE_INSTALL += " \
    ffmpeg \
    libexif \
    ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'optee-aes-decryptor ocdmi portmap', '', d)} \
    ${ACCEL_FW} \
    ${GSTREAMER_ACCEL_MM} \
    "
