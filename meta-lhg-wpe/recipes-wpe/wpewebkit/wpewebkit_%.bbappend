# removing commercial plugins 
RDEPS_EXTRA_remove = " \
                      gstreamer1.0-plugins-ugly-mpg123 \
                      gstreamer1.0-plugins-bad-hls \
                     "

EXTRA_OECMAKE_append_mx8 = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', '-DENABLE_SECURE_DATA_PATH=ON', '', d)}"

