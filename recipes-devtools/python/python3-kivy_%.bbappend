## Add patch for cutbuffer critical warning 
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://cutbuffer.patch \
    file://camera_gi.patch \
    file://kivy_opencv.patch \
   "

REQUIRED_DISTRO_FEATURES:remove = "x11"

ANY_OF_DISTRO_FEATURES = "x11 wayland"
