# Enable opencdm
PACKAGECONFIG_append = " opencdm"

# iMX8 gst 1.12 change
RDEPS_VIDEO_remove_imx = "gstreamer1.0-plugins-good-souphttpsrc"
RDEPS_VIDEO_append_imx = "gstreamer1.0-plugins-good-soup"
