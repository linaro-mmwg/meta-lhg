require recipes-samples/images/rpb-weston-image.bb

SUMMARY = "Basic Wayland image with WPE on Westeros"

CORE_IMAGE_BASE_INSTALL += " \
    packagegroup-wpewebkit \
    packagegroup-wpeframework \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'packagegroup-westeros', '', d)} \
    kmscube \
"

CORE_IMAGE_BASE_INSTALL_remove = " \
    weston \
    weston-examples \
    weston-init \
"

EXTRA_USERS_PARAMS += "\
usermod -a -G video linaro; \
"
