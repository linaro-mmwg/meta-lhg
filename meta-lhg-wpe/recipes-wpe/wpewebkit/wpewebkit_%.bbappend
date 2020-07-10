# removing commercial plugins
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-good-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "
# tmp SHA bump until https://github.com/WebPlatformForEmbedded/meta-wpe/pull/474 is merged 
SRCREV = "686cd2f7df15f05417537485fd02ccbe632e5b09"

# remove playready
PACKAGECONFIG_remove = "playready"

# add opencdm if optee detected - temp disabled
#PACKAGECONFIG_append = " ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'opencdm', '', d)}"

PACKAGECONFIG_remove = "westeros-sink"

CXXFLAGS_append_mx8 = " -DLINUX -DEGL_API_FB -DWL_EGL_PLATFORM"
