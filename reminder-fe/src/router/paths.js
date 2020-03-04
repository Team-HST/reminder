/**
 * @description 라우터 정보 객체
 */
export default [
  {
    path: '/login', name: 'loginView', component: 'LoginView',
    meta: { publicView: true }
  },
  {
    path: '/login-success', name: 'loginSuccessView', component: 'LoginSuccessView',
    meta: { publicView: true }
  },
  {
    path: '/dashboard', name: 'dashboardView', component: 'DashboardView', 
    meta: { publicView: false, menu: { name: 'DashBoard', icon: 'mdi-view-dashboard' } }
  },
  {
    path: '/channels', name: 'channelView', component: 'ChannelView', 
    meta: { publicView: false, menu: { name: 'Channels', icon: 'mdi-arrow-right-bold-box' } }
  },
  {
    path: '/tickets', name: 'ticketView', component: 'TicketView', 
    meta: { publicView: false, menu: { name: 'Tickets', icon: 'mdi-telegram' } }
  },
  {
    path: '/settings', name: 'settingView', component: 'SettingView', 
    meta: { publicView: false, menu: { name: 'Settings', icon: 'mdi-settings' } }
  },  
]