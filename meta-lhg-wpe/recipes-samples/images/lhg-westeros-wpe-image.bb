require recipes-samples/images/rpb-console-image.bb

SUMMARY = "Basic Wayland image with WPE on Westeros"

COMPATIBLE_MACHINE = "(hikey-32|dragonboard-410c-32|dragonboard-820c-32)"

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES += "wayland"

CORE_IMAGE_BASE_INSTALL += " \
    packagegroup-rpb-wayland \
    westeros \
    westeros-simplebuffer \
    westeros-simpleshell \
    westeros-soc \
    wpewebkit \
    wpebackend-rdk \
    wpelauncher \
"

EXTRA_USERS_PARAMS = " "
