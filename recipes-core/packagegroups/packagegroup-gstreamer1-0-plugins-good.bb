DESCRIPTION = "Gstreamer 1.0 pluggins good components"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

PR = "r0"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-gstreamer1-0-plugins-good \
    "

#---------------------------------------------------
# Information
# Possible configuration for version 1.4.5
#   x11: X libraries and plugins and extensions
#   pulseaudio: pulseaudio plug-in: pulseaudio
#   cairo: Cairo graphics rendering and gobject bindings: cairo
#   flac: FLAC lossless audio: flac
#   gdk-pixbuf: GDK pixbuf: gdkpixbuf
#   gudev:
#   jack: Jack: jack
#   jpeg: jpeg library
#   libpng: Portable Network Graphics library
#   soup: soup http client plugin (2.4): souphttpsrc
#   speex: speex speech codec: speex
#   taglib: taglib tagging library
#   vpx: VPX decoder
#   wavpack: wavpack plug-in
#   orc:


# Default configuration used:
# PACKAGECONFIG_pn-gstreamer1.0-plugins-good = " \
#    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
#    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio', '', d)} \
#    orc cairo flac gdk-pixbuf gudev jpeg libpng soup speex taglib \
#    "


# List of package generated (not complete):
#    1394: Source for video data via IEEE1394 interface
#    aasink: ASCII Art video sink
#    alaw: ALaw audio conversion routines
#    alpha: adds an alpha channel to video - constant or via chroma-keying
#    alphacolor: RGBA from/to AYUV colorspace conversion preserving the alpha channel
#    apetag: APEv1/2 tag reader
#    audiofx: Audio effects plugin
#    auparse: parses au streams
#    autodetect: Plugin contains auto-detection plugins for video/audio in- and outputs
#    avi: AVI stream handling
#    cacasink: Colored ASCII Art video sink
#    cairo: Cairo-based elements
#    cutter: Audio Cutter to split audio into non-silent bits
#    debug: elements for testing and debugging
#    deinterlace: Deinterlacer
#    directsound: DirectSound plugin
#    dtmf: DTMF plugins
#    dv: DV demuxer and decoder based on libdv (libdv.sf.net)
#    equalizer: GStreamer audio equalizers
#    effectv: effect plugins from the effectv project
#    flac: The FLAC Lossless compressor Codec
#    flv: FLV muxing and demuxing plugin
#    flxdec: FLC/FLI/FLX video decoder
#    gdkpixbuf: GdkPixbuf-based image decoder, overlay and sink
#    goom: GOOM visualization filter
#    goom2k1: GOOM 2k1 visualization filter
#    icydemux: Demux ICY tags from a stream
#    id3demux: Demux ID3v1 and ID3v2 tags from a file
#    imagefreeze: Still frame stream generator
#    interleave: Audio interleaver/deinterleaver
#    isomp4: ISO base media file format support (mp4, 3gpp, qt, mj2)
#    jack: JACK audio elements
#    jpeg: JPeg plugin library
#    level: Audio level plugin
#    matroska: Matroska and WebM stream handling
#    monoscope: Monoscope visualization
#    mulaw: MuLaw audio conversion routines
#    multifile: Reads/Writes buffers from/to sequentially named files
#    multipart: multipart stream manipulation
#    navigationtest: Template for a video filter
#    oss4: Open Sound System (OSS) version 4 support for GStreamer
#    ossaudio: OSS (Open Sound System) support for GStreamer
#    osxaudio: OSX (Mac OS X) audio support for GStreamer
#    osxvideo: OSX native video output plugin
#    png: PNG plugin library
#    pulseaudio: PulseAudio plugin library
#    replaygain: ReplayGain volume normalization
#    rtp: Real-time protocol plugins
#    rtpmanager: RTP session management plugin library
#    rtsp: transfer data via RTSP
#    shapewipe: Shape Wipe transition filter
#    shout2send: Sends data to an icecast server using libshout2
#    smpte: Apply the standard SMPTE transitions on video images
#    soup: libsoup HTTP client src/sink
#    spectrum: Run an FFT on the audio signal, output spectrum data
#    speex: Speex plugin library
#    taglib: Tag writing plug-in based on taglib
#    udp: transfer data via UDP
#    video4linux2: elements for Video 4 Linux
#    videobox: resizes a video by adding borders or cropping
#    videocrop: Crops video into a user-defined region
#    videofilter: Video filters plugin
#    videomixer: Video mixer
#    vpx: VP8 plugin
#    waveform: WaveForm API based plugin
#    wavenc: Encode raw audio into WAV
#    wavpack: Wavpack lossless/lossy audio format handling
#    wavparse: Parse a .wav file into raw audio
#    ximagesrc: X11 video input plugin using standard Xlib calls
#    y4menc: Encodes a YUV frame into the yuv4mpeg format (mjpegtools)


PROVIDES = "${PACKAGES}"

#The following list of package are sorted by:
# mandatory
# \
# selected by PACKAGECONFIG
# \
# others
RDEPENDS_packagegroup-gstreamer1-0-plugins-good = "\
    gstreamer1.0-plugins-good-meta \
    \
    gstreamer1.0-plugins-good-cairo \
    gstreamer1.0-plugins-good-flac \
    gstreamer1.0-plugins-good-jpeg \
    gstreamer1.0-plugins-good-png \
    gstreamer1.0-plugins-good-souphttpsrc \
    gstreamer1.0-plugins-good-taglib \
    \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-auparse \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-deinterlace \
    gstreamer1.0-plugins-good-flv \
    gstreamer1.0-plugins-good-flxdec \
    gstreamer1.0-plugins-good-id3demux \
    gstreamer1.0-plugins-good-interleave \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-level \
    gstreamer1.0-plugins-good-matroska \
    gstreamer1.0-plugins-good-multifile \
    gstreamer1.0-plugins-good-multipart \
    gstreamer1.0-plugins-good-rtp \
    gstreamer1.0-plugins-good-rtpmanager \
    gstreamer1.0-plugins-good-rtsp \
    gstreamer1.0-plugins-good-udp \
    gstreamer1.0-plugins-good-video4linux2 \
    gstreamer1.0-plugins-good-videocrop \
    gstreamer1.0-plugins-good-videofilter \
    gstreamer1.0-plugins-good-videomixer \
    gstreamer1.0-plugins-good-wavenc \
    gstreamer1.0-plugins-good-wavparse \
"


