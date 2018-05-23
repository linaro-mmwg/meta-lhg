FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# override WPEWebKit till ClearKey PR is merged
BASE_URI = "git://github.com/psivasubramanian/WebKitForWayland;protocol=git;branch=patch-8"
SRC_URI_append = "file://0001-incompatitable-types-fix.patch"
SRCREV = "233a70860b59c47a7c6bdda237412f987be0c4f2"

# removing commercial plugins 
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-ugly-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "
                     
# remove playready
PACKAGECONFIG_remove = "playready"

# enable opencdm
PACKAGECONFIG_append = " opencdm"
