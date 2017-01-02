# Git Setup

### DSA Repository Setup

![Git Setup Image](https://drive.google.com/uc?id=0B9O1OugmZywzdmlFdE42TWtTbFk "Setup")

To set up your DSA repositroy, first fork the repository `Olin-DSA/DSA-17`, which you can find [here](https://github.com/Olin-DSA/DSA-17).  Then clone your forked repository to your machine.

In order to pull any updates that we make to the original DSA-17 repository down to your own local copy, you need to link `Olin-DSA/DSA-17` as a remote.  When you clone a git repo, the remote **origin** is created for you automatically and links to the on-server repository that you cloned.  You can also add other remotes to push to or pull from using `git remote add remoteName serverURL`.  In this case we want to configure the remote **upstream** via 'git remote add upstream https://github.com/Olin-DSA/DSA-17'.  `git remote -v` will list all of your configured remote names as well as the server URLs that they are linked to, so you can use this to check that you successfully added the `Olin-DSA/DSA-17` repository.


### DSA Repository Usage

![Git Usage Image](https://drive.google.com/uc?id=0B9O1OugmZywzRGkxaVRkV1I5X0U "Usage")

Now that the remote has been added, you can pull updates at any time using `git pull upstream master` on top of pushing to pulling from your forked repository (**origin**) as usual.