//package controller;
//
//import model.Outcome;
//import service.ADRService;
//import service.impl.ADRServiceImpl;
//
//public enum Actions {
//    GET_ALL("show", new ADRServiceImpl()),
//    SAVE("save", new ADRServiceImpl());
//
//    private String action;
//    private ADRService service;
//
//    Actions(String action, ADRServiceImpl service) {
//        this.action = action;
//        this.service = service;
//    }
//
//    public static ADRService getByAction(String action) {
//        for (Actions act : Actions.values()) {
//            if (act.action.equalsIgnoreCase(action)) {
//                return act.service;
//            }
//        }
//        return null;
//    }
//}
