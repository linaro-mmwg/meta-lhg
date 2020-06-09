# removing commercial plugins 
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-ugly-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "
                     
# remove playready
PACKAGECONFIG_remove = "playready"

EXTRA_OECMAKE_append_mx8 = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', '-DENABLE_SECURE_DATA_PATH=ON', '', d)}"

