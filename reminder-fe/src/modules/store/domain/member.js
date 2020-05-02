import memberService from '@/modules/service/memberService'

const state = {
  authenticationToken: null,
  authorized: false,
  profile: null
}

const getters = {
  authorized(state) {
    return state.authorized
  },
  getAuthorizeToken(state) {
    return state.authenticationToken
  }
}

const mutations = {
  processAuthorize(state) {
    state.authorized = true
  },
  processDeAuthorize(state) {
    state.authorized = false
  },
  setAuthorizeToken(state, token) {
    state.authenticationToken = token
  },
  setProfile(state, memberProfile) {
    state.profile = memberProfile
  }
}

const actions = {
  deAuthorize(context) {
    context.commit('processDeAuthorize')
  },
  async authorize({ commit }, params) {
    commit('setAuthorizeToken', params.token) 
    
    let response = await memberService.getProfile(params.memberId);
    commit('setProfile', response.data);
    commit('processAuthorize');
  }
}

export default {
  // 네임스페이스로 분할화된 모듈 처리
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}