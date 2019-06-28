require recipes-samples/images/rpb-weston-image.bb

SUMMARY = "Basic Wayland image with WPE on Westeros"

CORE_IMAGE_BASE_INSTALL += " \
    kmscube \
    westeros \
    westeros-simplebuffer \
    westeros-simpleshell \
    westeros-soc \
    wpewebkit \
    wpebackend-rdk \
    wpeframework \
    wpeframework-plugins \
"

CORE_IMAGE_BASE_INSTALL_remove = " \
    weston \
    weston-examples \
    weston-init \
"

EXTRA_USERS_PARAMS = " "
