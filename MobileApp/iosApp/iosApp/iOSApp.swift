import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    var dependenciesProviderHelper = DependenciesProviderHelper()
    init() {
       dependenciesProviderHelper.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
