LINUX_VERSION = "6.1.5"
YOCTO_META ?= "git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.1;destsuffix=yocto-kmeta"
KBRANCH="xlnx_rebase_v6.1_LTS"
SRCREV = "29254e79098cb82453d8c68f431d7588856ebdff"
SRCREV_meta = "185bcfcbe480c742247d9117011794c69682914f"

KCONF_AUDIT_LEVEL="0"

include linux-xlnx.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
