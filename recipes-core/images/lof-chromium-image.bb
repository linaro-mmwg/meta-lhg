DESCRIPTION = "Linaro OpenFramework image."

PV = "1.0.0"
PR = "r1"

LICENSE = "MIT"

IMAGE_BROWSER = " \
    libexif \
    chromium \
"

IMAGE_INSTALL += " \
    ${IMAGE_BROWSER} \
"
include recipes-core/images/lof-mm-image.bb
