# Git Setup

## DSA Repository Setup

![Git Setup Image](https://drive.google.com/uc?id=0B9O1OugmZywzdmlFdE42TWtTbFk "Setup")

### Forking the DSA-17 Repository
To set up your DSA repository, first fork `Olin-DSA/DSA-17`, which you can find [here](https://github.com/Olin-DSA/DSA-17).  Then clone your forked repository to your machine.

### Adding a Remote Repository 
In order to pull any updates that we make to the original DSA-17 repository down to your own local copy, you need to link `Olin-DSA/DSA-17` as a remote.  When you clone a git repo, the remote **origin** is created for you automatically and links to the on-server repository that you cloned.  You can also add other remotes to push to or pull from using `git remote add remoteName serverURL`.  In this case we want to configure a new remote with the name **upstream** and the server URL https://github.com/Olin-DSA/DSA-17.  `git remote -v` will list all of your configured remote names as well as the server URLs that they are linked to, so you can use this to check that you successfully added the `Olin-DSA/DSA-17` repository as **upstream**.


## DSA Repository Usage

![Git Usage Image](https://drive.google.com/uc?id=0B9O1OugmZywzRGkxaVRkV1I5X0U "Usage")

### Updating DSA-17
Now that the remote has been added, you can pull updates from **upstream** at any time using `git pull upstream master` on top of pushing to and pulling from your forked repository (**origin**) as usual.