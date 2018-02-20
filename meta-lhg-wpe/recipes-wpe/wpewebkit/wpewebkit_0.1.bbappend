FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "file://0001-incompatitable-types-fix.patch"

# removing commercial plugins 
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-ugly-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "
                     
# remove playready
PACKAGECONFIG_remove = "playready"
