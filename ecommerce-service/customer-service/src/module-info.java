module customer.service {
    requires user.service;
    provides io.mohsinkd786.services.apis.UserService with io.mohsinkd786.services.UserServiceImpl;
}
