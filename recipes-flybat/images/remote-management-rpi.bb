include recipes-core/images/rpi-basic-image.bb
include recipes-flybat/images/remote-management-base.bb

# Raspberry pi related things
IMAGE_INSTALL_append=" fixruntimehack enable-i2c-dev "
IMAGE_INSTALL_append=" linux-firmware-bcm43430 "
