DESCRIPTION = "Linaro OpenFramework image."

PV = "1.0.0"
PR = "r1"

LICENSE = "MIT"

#
# Multimedia part addons
#
IMAGE_MM_PART = " \
    tiff \
    libv4l \
    rc-keymaps \
"

#
# Audio part addons
#
IMAGE_AUDIO_PART = " \
    alsa-lib \
    alsa-utils \
"

IMAGE_INSTALL += " \
    ${IMAGE_MM_PART} \
    ${IMAGE_AUDIO_PART} \
"
include recipes-core/images/lof-weston-image.bb
