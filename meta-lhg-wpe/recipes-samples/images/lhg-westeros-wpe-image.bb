require recipes-samples/images/rpb-weston-image.bb

SUMMARY = "Basic Wayland image with WPE on Westeros"

CORE_IMAGE_BASE_INSTALL += " \
    westeros \
    wpe \
    wpe-launcher \
"

CORE_IMAGE_BASE_INSTALL_remove = " \
    weston \
    weston-examples \
    weston-init \
"

EXTRA_USERS_PARAMS = " "
