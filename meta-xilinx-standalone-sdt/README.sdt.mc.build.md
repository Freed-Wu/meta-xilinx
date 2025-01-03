# AMD SDT Multiconfig Build Instructions

This readme describes how to build multiconfig baremetal baremetal or freertos
applications. Once the applications are built it can be package and deploy baremetal
or freertos application elf or bin files to linux root filesystem under /lib/firmware
directory.

## How to configure and build multiconfig baremetal or freertos applications

1. Follow [SDT Building Instructions](README.sdt.bsp.md) upto step 3.

2. By default minimal set of multiconfigs are generated by gen-machineconf tool.
   To build multiconfig(APU/RPU baremetal or FreeRTOS) use `--multiconfigfull`
   option to enable full multiconfig(avaiable all APU/RPU cores).
> **Note:**
> 1. To enable multiconfigs for selected APU/PRU cores then use `--meunuconfig`
>    options from gen-machineconf tool to generate the Kconfig menu and go to
>    `Multiconfig Targets` to make the selection.
> 2. Example usage:
> ```   
> $ gen-machineconf parse-sdt --hw-description <path_to_sdtgen_output_directory> -c <conf-directory> -l <path-to-build-directory>/build/conf/local.conf --machine-name <soc-family>-<board-name>-sdt-<design-name> --multiconfig --menuconfig
> ```

3. Run following command to build multiconfig baremetal baremetal or freertos applications.
> **Note:** See [recipes-applications](./recipes-applications/) directory for
> list of available multiconfig applications.

* Usage:
```
$ bitbake mc:<soc-family>-<board-name>-sdt-<design-name>-<apu-or-rpu>-<cpu-core-number>-<baremetal-or-freertos>:<application-recipe-name>
```
* Example:
```
$ bitbake mc:versal-vek280-sdt-cortexr5-0-freertos:freertos-hello-world
```

4. Follow [Firware Packaging Instructions](../docs/README.fw.package.md) if you
   need to package the multiconfig applications to linux rootfs or Follow
   [SDT Building Instructions](README.sdt.bsp.md) and continue from step 5 to build
   target images.
