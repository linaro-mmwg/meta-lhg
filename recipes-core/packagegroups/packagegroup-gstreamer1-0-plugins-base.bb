DESCRIPTION = "Gstreamer 1.0 pluggins base components"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

PR = "r0"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-gstreamer1-0-plugins-base \
    "

#---------------------------------------------------
# Information
# Possible configuration for version 1.4.5
#   x11: X libraries and plugins and extensions
#   alsa: alsa
#   ivorbis: integer vorbis plug-in
#   ogg: Xiph Ogg library
#   theora: Xiph Theora video codec: theora
#   vorbis: Xiph Vorbis audio codec: vorbis
#   pango: Pango font rendering (Text overlay)
#   encoding:
#   orc:
#
# Default configuration used:
#  PACKAGECONFIG_pn-gstreamer1.0-plugins-base = " \
#      ${@base.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
#      ${@base_contains('DISTRO_FEATURES', 'alsa', 'alsa', '', d)} \
#      orc ivorbis ogg theora vorbis \
#      pango encoding \
#  "
#
# List of package generated (not complete):
#    adder: Adds multiple streams
#    alsa: ALSA plugin library
#    app: Elements used to communicate with applications
#    audioconvert: Convert audio to different formats
#    audiorate: Adjusts audio frames
#    audioresample: Resamples audio
#    audiotestsrc: Creates audio test signals of given frequency and volume
#    cdparanoia: Read audio from CD in paranoid mode
#    encoding: various encoding-related elements
#    videoconvert: Colorspace conversion
#    gio: GIO elements
#    libvisual: libvisual visualization plugins
#    ogg: ogg stream manipulation (info about ogg: http://xiph.org)
#    pango: Pango-based text rendering and overlay
#    playback: various playback elements
#    subparse: Subtitle parsing
#    tcp: transfer data over the network via TCP
#    theora: Theora plugin library
#    typefind: functionsdefault typefind functions
#    videorate: Adjusts video frames
#    videoscale: Resizes video
#    videotestsrc: Creates a test video stream
#    volume: plugin for controlling audio volume
#    vorbis: Vorbis plugin library
#    ximagesink: X11 video output element based on standard Xlib calls
#    xvimagesink: XFree86 video output plugin using Xv extension


PROVIDES = "${PACKAGES}"

#The following list of package are sorted by:
# mandatory
# \
# selected by PACKAGECONFIG
# \
# others
RDEPENDS_packagegroup-gstreamer1-0-plugins-base = "\
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-apps \
    gstreamer1.0-plugins-base-meta \
    \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-base-ivorbisdec \
    gstreamer1.0-plugins-base-ogg \
    gstreamer1.0-plugins-base-theora \
    gstreamer1.0-plugins-base-vorbis \
    gstreamer1.0-plugins-base-pango \
    gstreamer1.0-plugins-base-encodebin \
    \
    gstreamer1.0-plugins-base-adder \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audiorate \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-audiotestsrc \
    gstreamer1.0-plugins-base-playback \
    gstreamer1.0-plugins-base-subparse \
    gstreamer1.0-plugins-base-tcp \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-base-videoconvert \
    gstreamer1.0-plugins-base-videorate \
    gstreamer1.0-plugins-base-videoscale \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-base-volume \
"
