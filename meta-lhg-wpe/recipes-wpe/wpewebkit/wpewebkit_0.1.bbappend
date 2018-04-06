FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# override WPEWebKit branch to wpe-20161117 aligining with Metrological
BASE_URI = "git://github.com/WebPlatformForEmbedded/WPEWebKit.git;protocol=git;branch=wpe-20161117"
SRC_URI_append = "file://0001-incompatitable-types-fix.patch"

# removing commercial plugins 
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-ugly-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "
                     
# remove playready
PACKAGECONFIG_remove = "playready"
