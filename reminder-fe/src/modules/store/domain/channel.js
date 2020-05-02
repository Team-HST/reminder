import channelService from '@/modules/service/channelService'

import { CollectionUtils } from '@/utils/common'

const state = {
  channels: {
    created: [],
    involved: []    
  }
}

const mutations = {
  setCreatedChannels(state, createdChannels) {
    state.channels.created = createdChannels;
  },
  setInvolvedChannels(state, involvedChannels) {
    state.channels.involved = involvedChannels;
  },
  removeChannel(state, channelIds) {
    channelIds.forEach(channelId => {
      CollectionUtils.remove(state.channels.created, e => e.id === channelId)
      CollectionUtils.remove(state.channels.involved, e => e.id === channelId)
    })
  }
}

const getters = {
}

const actions = {
  async getCreatedChannels({ commit }, memberId) {
    let response = await channelService.getCreatedChannels(memberId);
    commit('setCreatedChannels', response.data.channels);
  },
  async getInvolvedChannels({ commit }, memberId) {
    let response = await channelService.getInvolvedChannels(memberId);
    commit('setInvolvedChannels', response.data.channels);
  },
  deleteChannels({ commit }, channelIds) {
    channelService.deleteChannel(channelIds).then(() => {
      commit('removeChannel', channelIds)
    })
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