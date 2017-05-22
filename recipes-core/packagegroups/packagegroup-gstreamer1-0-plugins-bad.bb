DESCRIPTION = "Gstreamer 1.0 pluggins bad components"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

PR = "r0"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-gstreamer1-0-plugins-bad \
    "

#---------------------------------------------------
# Information
# Possible configuration for version 1.4.5
# assrender: ASS/SSA renderer
# curl: Curl plugin
# gles2: gles effect
# opengl:
# faac: AAC encoder plug-in
# faad: AAC decoder plug-in
# libmms: mms protocol library
# modplug: modplug
# mpg123: mpg123 audio decoder
# opus: opus
# flite: Flite plugin
# opencv: opencv plugins
# wayland: wayland sink
# uvch264: UVC H264
# directfb: dfbvideosink
# neon: neon http client plugins: neonhttpsrc
# openal: OpenAL plugin
# hls: http live streaming plugin
# sbc: SBC bluetooth audio codec
# dash: dash = Dynamic Adaptive Streaming over HTTP
# bz2: bz2 library
# fluidsynth: fluidsynth
# schroedinger: Schroedinger video codec
# smoothstreaming: Smooth Streaming plug-in
# bluez: Bluez
# rsvg: rsvg decoder
# sndfile:
# webp:
# rtmp:
# linssh2:
# orc:


# Default configuration used:
# PACKAGECONFIG_pn-gstreamer1.0-plugins-bad = " \
#    ${@base_contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
#    ${@base_contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)} \
#    ${@base_contains('DISTRO_FEATURES', 'bluetooth', 'bluez', '', d)} \
#    ${@base_contains('DISTRO_FEATURES', 'directfb', 'directfb', '', d)} \
#    orc curl uvch264 neon \
#    hls sbc dash bz2 smoothstreaming \
#    faad faac \
#    "


# List of package generated (not complete):
#    autoconvert: Selects convertor element based on caps
#    assrender: ASS/SSA subtitle renderer
#    bayer: Elements to convert Bayer images
#    bz2: Compress or decompress streams
#    camerabin: Take image snapshots and record movies from camera
#    coloreffects: Color Look-up Table filters
#    curl: libcurl-based elements
#    dataurisrc: data: URI source
#    debugutilsbad: Collection of elements that may or may not be useful for debugging
#    dtsdec: Decodes DTS audio streams
#    dvb: DVB elements
#    dvdspu: DVD Sub-picture Overlay element
#    faac: Free AAC Encoder (FAAC)
#    faad: Free AAC Decoder (FAAD)
#    festival: Synthesizes plain text into audio
#    gaudieffects: Gaudi video effects.
#    geometrictransform: Various geometric image transform elements
#    gsm: GSM encoder/decoder
#    jpegformat: JPEG interchange format plugin
#    liveadder: Adds multiple live discontinuous streams
#    mimic: Mimic codec
#    mms: Microsoft Multi Media Server streaming protocol support
#    modplug.: MOD audio decoding
#    mpeg2enc: High-quality MPEG-1/2 video encoder
#    mpegtsmux: MPEG-TS muxer
#    mplex: High-quality MPEG/DVD/SVCD/VCD video/audio multiplexer
#    neon: lib neon http client src
#    ofa: Calculate MusicIP fingerprint from audio files
#    openal: OpenAL plugin library
#    opencv: GStreamer OpenCV Plugins
#    pcapparse: Element parsing raw pcap streams
#    rawparse: Parses byte streams into raw frames
#    rfbsrc: Connects to a VNC server and decodes RFB stream
#    rtmp: RTMP source and sink
#    sdp: configure streaming sessions using SDP
#    shm: shared memory sink source
#    soundtouch: Audio Pitch Controller & BPM Detection
#    speed: Set speed/pitch on audio/raw streams (resampler)
#    voaacenc: AAC audio encoder
#    voamrwbenc: Adaptive Multi-Rate Wide-Band Encoder
#    zbar: zbar barcode scanner


PROVIDES = "${PACKAGES}"

#The following list of packages are sorted by:
# mandatory
# \
# selected by PACKAGECONFIG
# \
# others
RDEPENDS_packagegroup-gstreamer1-0-plugins-bad = "\
    gstreamer1.0-plugins-bad-meta \
    \
    gstreamer1.0-plugins-bad-curl \
    gstreamer1.0-plugins-bad-neonhttpsrc \
    gstreamer1.0-plugins-bad-fragmented \
    gstreamer1.0-plugins-bad-dashdemux \
    gstreamer1.0-plugins-bad-bz2 \
    gstreamer1.0-plugins-bad-smoothstreaming \
    \
    gstreamer1.0-plugins-bad-dvb \
    gstreamer1.0-plugins-bad-dvbsuboverlay \
    gstreamer1.0-plugins-bad-dvdspu \
    gstreamer1.0-plugins-bad-gaudieffects \
    gstreamer1.0-plugins-bad-id3tag \
    gstreamer1.0-plugins-bad-inter \
    gstreamer1.0-plugins-bad-interlace \
    gstreamer1.0-plugins-bad-jpegformat \
    gstreamer1.0-plugins-bad-liveadder \
    gstreamer1.0-plugins-bad-mpegpsdemux \
    gstreamer1.0-plugins-bad-mpegpsmux \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-mpegtsmux \
    gstreamer1.0-plugins-bad-opengl \
    gstreamer1.0-plugins-bad-sdpelem \
    gstreamer1.0-plugins-bad-segmentclip \
    gstreamer1.0-plugins-bad-shm \
    gstreamer1.0-plugins-bad-smooth \
    gstreamer1.0-plugins-bad-speed \
    gstreamer1.0-plugins-bad-subenc \
    gstreamer1.0-plugins-bad-videofiltersbad \
    gstreamer1.0-plugins-bad-videoparsersbad \
    gstreamer1.0-plugins-bad-sbc \
    gstreamer1.0-plugins-bad-waylandsink \
    \
"


