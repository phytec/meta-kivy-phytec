## Add patch for cutbuffer critical warning 
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://cutbuffer.patch \
    file://kivy_gstreamer.patch \
    file://kivy_opencv.patch \
    "

# Add egl dependency 
#DEPENDS += " \
#    virtual/egl \
#"
