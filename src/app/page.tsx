'use client'

import { useState, useEffect } from 'react'
import { Loader2 } from 'lucide-react'

export default function Home() {
  const [isLoading, setIsLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    // Simulate minimum loading time for splash screen
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 1500)

    return () => clearTimeout(timer)
  }, [])

  const handleIframeLoad = () => {
    setIsLoading(false)
  }

  const handleIframeError = () => {
    setError('연결 실패. 네트워크를 확인해주세요.')
    setIsLoading(false)
  }

  return (
    <div className="fixed inset-0 flex flex-col bg-background">
      {/* Loading Overlay */}
      {isLoading && (
        <div className="absolute inset-0 z-50 flex flex-col items-center justify-center bg-background">
          <div className="flex flex-col items-center gap-4">
            <div className="relative w-20 h-20">
              <img
                src="/logo.svg"
                alt="Z AI Logo"
                className="w-full h-full object-contain animate-pulse"
              />
            </div>
            <div className="flex items-center gap-2 text-muted-foreground">
              <Loader2 className="w-4 h-4 animate-spin" />
              <span className="text-sm">연결 중...</span>
            </div>
          </div>
        </div>
      )}

      {/* Error State */}
      {error && (
        <div className="absolute inset-0 z-50 flex flex-col items-center justify-center bg-background p-6">
          <div className="flex flex-col items-center gap-4 text-center">
            <div className="w-16 h-16 rounded-full bg-destructive/10 flex items-center justify-center">
              <svg
                className="w-8 h-8 text-destructive"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={2}
                  d="M12 9v2m0 4h.01m-6.938 4h13.856c1.54 0 2.502-1.667 1.732-3L13.732 4c-.77-1.333-2.694-1.333-3.464 0L3.34 16c-.77 1.333.192 3 1.732 3z"
                />
              </svg>
            </div>
            <div>
              <h2 className="text-lg font-semibold">연결 실패</h2>
              <p className="text-sm text-muted-foreground mt-1">{error}</p>
            </div>
            <button
              onClick={() => {
                setError(null)
                setIsLoading(true)
                window.location.reload()
              }}
              className="px-4 py-2 bg-primary text-primary-foreground rounded-lg text-sm font-medium hover:bg-primary/90 transition-colors"
            >
              다시 시도
            </button>
          </div>
        </div>
      )}

      {/* Main iframe */}
      <iframe
        src="https://chat.z.ai"
        className="flex-1 w-full h-full border-0"
        onLoad={handleIframeLoad}
        onError={handleIframeError}
        allow="microphone; camera; clipboard-write; clipboard-read; geolocation; fullscreen"
        sandbox="allow-same-origin allow-scripts allow-forms allow-popups allow-modals allow-top-navigation"
        title="Z AI Chat"
      />
    </div>
  )
}
