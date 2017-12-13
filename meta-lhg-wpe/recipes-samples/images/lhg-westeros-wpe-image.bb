require recipes-samples/images/rpb-console-image.bb

SUMMARY = "Basic Wayland image with WPE on Westeros"

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES += "wayland"

CORE_IMAGE_BASE_INSTALL += " \
    packagegroup-rpb-wayland \
    packagegroup-westeros \
    packagegroup-wpe \
"

EXTRA_USERS_PARAMS = " "
