//
//  EgunMoneyIPhoneAppDelegate.h
//  EgunMoneyIPhone
//
//  Created by dongkyu lee on 11. 1. 31..
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class EgunMoneyIPhoneViewController;

@interface EgunMoneyIPhoneAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    EgunMoneyIPhoneViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet EgunMoneyIPhoneViewController *viewController;

@end

