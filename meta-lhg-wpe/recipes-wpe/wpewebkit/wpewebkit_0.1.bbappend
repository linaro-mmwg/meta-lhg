FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# override WPEWebKit till ClearKey PR is merged
# clearkey validated from 'patch-8' branch
# with 'pr_working' branch, no proper url available to validate clearkey
BASE_URI = "git://github.com/psivasubramanian/WebKitForWayland;protocol=git;branch=pr_working"
SRC_URI_append = " file://0001-incompatitable-types-fix.patch"
SRCREV = "638d978d2bab09fb4fc31b8878461a4fa32b45fc"

# to avoid maximum call stack size range error
# validated in Hikey and iMX8M platforms
SRC_URI_remove = " \
            file://0001-Reduce-the-default-thread-stack-size-to-32KB.patch \
            file://0001-Reduce-stack-limits.patch \
           "

RDEPS_VIDEO_remove_mx8 = " gstreamer1.0-plugins-good-souphttpsrc"
RDEPS_VIDEO_append_mx8 = " gstreamer1.0-plugins-good-soup"

# removing commercial plugins 
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-ugly-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "

# remove playready
PACKAGECONFIG_remove = "playready"

# enable opencdm
PACKAGECONFIG_append = " opencdm"
